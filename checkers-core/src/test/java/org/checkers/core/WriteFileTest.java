package org.checkers.core;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.Test;

public class WriteFileTest {

  @Test
  public void testWriteOnFile(){
     String inputData = "1,2,3,4,5,6,7,8,9";

     File file = new File("newfile.txt");

     try {
       file.createNewFile();
     } catch (IOException e) {
       e.printStackTrace();
     }

     WriteFile writeFile = new WriteFile(file);
     writeFile.clearFile(file);
     writeFile.saveHistory(inputData);

     ReadFile readfile = new ReadFile();
     List<String> strings = readfile.ReadFiles(file);
     String outputData = strings.get(0);

     assertEquals(inputData, outputData);

  }

  @Test
  public void testWriteMultipleLinesOnFile(){
     String inputData1 = "1,2,3,4,5,6,7,8,9";
     String inputData2 = "a,b,c,d,e,f,g,h";

     File file = new File("newfile.txt");

     try {
       file.createNewFile();
     } catch (IOException e) {
       e.printStackTrace();
     }

     WriteFile writeFile = new WriteFile(file);
     writeFile.clearFile(file);
     writeFile.saveHistory(inputData1);
     writeFile.saveHistory(inputData2);

     ReadFile readfile = new ReadFile();
     List<String> strings = readfile.ReadFiles(file);
     String outputData1 = strings.get(0);
     String outputData2 = strings.get(1);

     assertEquals(inputData1, outputData1);
     assertEquals(inputData2, outputData2);

  }

  @Test
  public void testClearLinesOnFile(){
     String inputData1 = "1,2,3,4,5,6,7,8,9";

     File file = new File("newfile.txt");

     try {
       file.createNewFile();
     } catch (IOException e) {
       e.printStackTrace();
     }

     WriteFile writeFile = new WriteFile(file);
     writeFile.saveHistory(inputData1);

     writeFile.clearFile(file);

     ReadFile readfile = new ReadFile();
     List<String> strings = readfile.ReadFiles(file);

     assertEquals(0, strings.size());
  }
}
