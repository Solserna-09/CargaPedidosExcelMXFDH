package com.eliteprofesional.cmpc.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ChangeLineInFile {

    public static void Tratamiento(String PATH_FILE, String Nombre) {
        SimpleDateFormat formateador = new SimpleDateFormat(
                "dd-MM-yyyy-HH:mm", new Locale("es_ES"));
        Date fechaDate = new Date();
        String fecha = formateador.format(fechaDate);
        String content = new String();
        String editedContent = new String();
        String Datos = "Fecha " + fecha + " " + Nombre;
        content = readFile(PATH_FILE);
        editedContent = editLineInContent(content, "Característica:" + " " + Datos, 4);
        writeToFile(PATH_FILE, editedContent);
    }

    private static int numberOfLinesInFile(String content) {
        int numberOfLines = 0;
        int index = 0;
        int lastIndex = 0;
        lastIndex = content.length() - 1;
        while (true) {
            if (content.charAt(index) == '\n') {
                numberOfLines++;
            }
            if (index == lastIndex) {
                numberOfLines = numberOfLines + 1;
                break;
            }
            index++;
        }
        return numberOfLines;
    }

    private static String[] turnFileIntoArrayOfStrings(String content, int lines) {
        String[] array = new String[lines];
        int index = 0;
        int tempInt = 0;
        int startIndext = 0;
        int lastIndex = content.length() - 1;
        while (true) {
            if (content.charAt(index) == '\n') {
                tempInt++;
                String temp2 = new String();
                for (int i = 0; i < index - startIndext; i++) {
                    temp2 += content.charAt(startIndext + i);
                }
                startIndext = index;
                array[tempInt - 1] = temp2;
            }
            if (index == lastIndex) {
                tempInt++;
                String temp2 = new String();
                for (int i = 0; i < index - startIndext + 1; i++) {
                    temp2 += content.charAt(startIndext + i);
                }
                array[tempInt - 1] = temp2;
                break;
            }
            index++;
        }
        return array;
    }

    private static String editLineInContent(String content, String newLine, int line) {
        int lineNumber = 0;
        lineNumber = numberOfLinesInFile(content);
        String[] lines = new String[lineNumber];
        lines = turnFileIntoArrayOfStrings(content, lineNumber);
        if (line != 1) {
            lines[line - 1] = "\n" + newLine;
        } else {
            lines[line - 1] = newLine;
        }
        content = new String();

        for (int i = 0; i < lineNumber; i++) {
            content += lines[i];
        }
        return content;
    }

    private static void writeToFile(String file, String content) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"))) {
            writer.write(content);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static String readFile(String filename) {
        String content = null;
        File file = new File(filename);
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return content;
    }
}