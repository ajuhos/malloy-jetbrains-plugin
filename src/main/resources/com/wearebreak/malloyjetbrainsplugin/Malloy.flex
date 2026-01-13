package com.wearebreak.malloyjetbrainsplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static com.wearebreak.malloyjetbrainsplugin.MalloyTokenTypes.*;

%%

%class MalloyLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \t\f]
COMMENT="//"[^\r\n]* | "--"[^\r\n]*
KEYWORD="source"|"query"|"run"|"project"|"group_by"|"aggregate"|"nest"|"where"|"order_by"|"limit"|"index"|"is"|"extend"|"measure"|"dimension"|"true"|"false"|"null"|"select"|"calculate"|"join_one"|"join_many"|"join_cross"|"on"|"with"|"primary_key"|"import"
FUNCTION="table"|"count"|"sum"|"avg"|"min"|"max"|"now"
NUMBER=[0-9]+(\.[0-9]+)?
TIME="@"[0-9]{4}(-[0-9]{2}(-[0-9]{2}([ T][0-9]{2}:[0-9]{2}:[0-9]{2}(\.[0-9]+)?(Z|[+-][0-9]{2}:?[0-9]{2})?)?)?)?
STRING=\"([^\"\\]|\\.)*\" | \'([^\'\\]|\\.)*\' | \`([^\`\\]|\\.)*\`
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*

%%

<YYINITIAL> {
  {KEYWORD}      { return KEYWORD; }
  {FUNCTION}     { return FUNCTION; }
  {NUMBER}       { return NUMBER; }
  {TIME}         { return TIME; }
  {COMMENT}      { return COMMENT; }
  {STRING}       { return STRING; }
  {IDENTIFIER}   { return IDENTIFIER; }
  {WHITE_SPACE}+ { return com.intellij.psi.TokenType.WHITE_SPACE; }
  {CRLF}+        { return com.intellij.psi.TokenType.WHITE_SPACE; }
}

[^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }