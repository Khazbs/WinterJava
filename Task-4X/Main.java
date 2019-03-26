import java.io.*;

public class Main {
    private enum At {
        NOT_COMMENT, SLASH, LINE_COMMENT, BLOCK_COMMENT, ASTERISK
    }
    public static void main(String[] args) throws IOException {
        String filename;
        try {
            filename = args[0];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No argument passed to the program");
            return;
        }
        int c;
        At at = At.NOT_COMMENT;
        try (Reader fileReader = new FileReader(filename)) {
           while ((c = fileReader.read()) != -1) {
               switch (at) {
                   case NOT_COMMENT: {
                       if (c == '/')
                           at = At.SLASH;
                       else
                           System.out.print((char) c);
                       break;
                   }
                   case SLASH: {
                       if (c == '/')
                           at = At.LINE_COMMENT;
                       else if (c == '*')
                           at = At.BLOCK_COMMENT;
                       else {
                           at = At.NOT_COMMENT;
                           System.out.print("/" + (char) c);
                       }
                       break;
                   }
                   case LINE_COMMENT: {
                       if (c == '\n') {
                           at = At.NOT_COMMENT;
                           System.out.println();
                       }
                       break;
                   }
                   case BLOCK_COMMENT: {
                       if (c == '*')
                           at = At.ASTERISK;
                       break;
                   }
                   case ASTERISK: {
                       if (c == '/')
                           at = At.NOT_COMMENT;
                       else
                           at = At.BLOCK_COMMENT;
                   }
               }
           }
        }
    }
}

