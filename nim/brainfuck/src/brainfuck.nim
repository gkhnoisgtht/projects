proc interpret*(code: string) = 
  ## Interprets the brainfuck `code` string, reading from stdin and writing to
  ## stdout.

  {.push overflowchecks: off.}
  proc xinc(c: var char) = inc c
  proc xdec(c: var char) = dec c
  {.pop.}


  var
    tape = newSeq[char]()
    codePos = 0
    tapePos = 0

  proc run(skip = false): bool = 
    while tapePos >= 0 and codePos < code.len:
      if tapePos >= tape.len:
        tape.add '\0'

      if code[codePos] == '[':
        inc codePos
        let oldPos = codePos
        while run(tape[tapePos] == '\0'):
          codePos = oldPos
      elif code[codePos] == ']':
        return tape[tapePos] != '\0'
      elif not skip:
        case code[codePos]
        of '+': xinc tape[tapePos]
        of '-': xdec tape[tapePos]
        of '>': inc tapePos
        of '<': dec tapePos
        of '.': stdout.write tape[tapePos]
        of ',': tape[tapePos] = stdin.readChar
        else: discard

      inc codePos

  discard run()

import macros

proc compile(code: string): NimNode {.compiletime.} =
  var stmts = @[newStmtList()]

  template addStmt(text): stmt = 
    stmts[stmts.high].add parseStmt(text)

  addStmt "var tape: array[1_000_000, char]"
  addStmt "var tapePos = 0"

  for c in code:
    case c
    of '+': addStmt "xinc tape[tapePos]"
    of '-': addStmt "xdec tape[tapePos]"
    of '>': addStmt "inc tapePos"
    of '<': addStmt "dec tapePos"
    of '.': addStmt "stdout.write tape[tapePos]"
    of ',': addStmt "tape[tapePos] = stdin.readChar"
    of '[': stmts.add new StmtList()
    of ']':
       var loop = new NimNode(nnkWhileStmt)
       loop.add parseExpr("tape[tapePos] != '\\0'")
       loop.add stmts.pop
       stmts[stmts.high].add loop
    else: discard

  result = stmts[0]
  echo result.repr

when isMainModule:
  echo "Welcome to brainfuck"

  import os

  let code = if paramCount() > 0: readFile paramStr(1)
             else: readAll stdin

  interpret code

