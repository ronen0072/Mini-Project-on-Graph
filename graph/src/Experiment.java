import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Experiment {
    public static void main(String[] args) throws Exception {
        String directory = "D:/מסמכים/java1/Mini-Project-on-Graph/";
        String fileName = "experiment";
        int numOfVertices = 200;
        double epsilon = 0.5;

        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        for (double i = 0.2; i <= 1; i += 0.2){
            for (double j = 0.01; j <= 0.1; j += 0.02) {
                String experimentName = "experiment, " + String.format("%.1g", i) + ", " + String.format("%.1g", j);
                System.out.println(experimentName + " Started");
                Map<String, Object[]> experimentInfo = new TreeMap<String, Object[]>();
                XSSFSheet spreadsheet = workbook.createSheet(experimentName);
                experimentInfo.put("1", new Object[]{
                        "K", "NO edgs in the original graph", "NO edgs in the spanner", "name of Vertex 1", "name of Vertex 2", "original Distance", "Distance in the spanner"});
                int counter = 1;
                for (int m = 0; m < 5; m++){
                    Graph g = new Graph(experimentName, numOfVertices, i, j);
                    Set<SuperVertex> randomVerticesTemp = new HashSet<SuperVertex>();
                    while (randomVerticesTemp.size() < 10) {
                        randomVerticesTemp.add(g.getRandomVertex());
                    }

                    SuperVertex[] randomVertices = randomVerticesTemp.toArray(new SuperVertex[randomVerticesTemp.size()]);
                    for (int k = 3; k <= 7; k++) {
                        Graph h = SpCons.SpCons(g, k, epsilon);
                        for (int v = 0; v < randomVertices.length; v++) {
                            for (int u = v + 1; u < randomVertices.length; u++) {
                                counter++;
                                experimentInfo.put(String.valueOf(counter), new Object[]{
                                        String.valueOf(k),
                                        String.valueOf(g.numOfEdges()),
                                        String.valueOf(h.numOfEdges()),
                                        randomVertices[v].toString(),
                                        randomVertices[u].toString(),
                                        String.valueOf(g.getDistance(randomVertices[v], randomVertices[u])),
                                        String.valueOf(h.getDistance(randomVertices[v], randomVertices[u]))
                                });
                            }
                        }
                    }
                }
                writeTo(experimentInfo, spreadsheet);
                System.out.println(experimentName+ " Finished");
            }
        }

        //Write the workbook in file system
        String m = "You need to close the "+fileName+" in order to continue !!!";
        boolean writtenSuccessfully = false;
        while (!writtenSuccessfully) {
            try {
                FileOutputStream out = new FileOutputStream(
                        new File(directory + fileName));

                workbook.write(out);
                out.close();
                System.out.println(fileName + " written successfully");
                writtenSuccessfully = true;

            } catch (FileNotFoundException e) {
                if (m != null) {
                    System.out.println(m);
                    m = null;
                }
                TimeUnit.SECONDS.sleep(20);
            }
        }
    }


    private static void writeTo(Map<String, Object[]> experimentInfo, XSSFSheet spreadsheet){
        XSSFRow row;
        Set< String > keyid = experimentInfo.keySet();
        int rowid = 0;
        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object [] objectArr = experimentInfo.get(key);
            int cellid = 0;

            for (Object obj : objectArr){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }
    }
}

