/**
 * @author Yaaqov Shkifati
 * @Since 9/30/2020
 * @verison 2.0
 */
package spotifychart;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;

/**
 * The SpotifyChart class reads CSV file that contains the top streaming songs
 * and artist from spotify website. The purpose of this class is to retrieve the
 * artist data and sorted it in alphabetical order and remove any duplicate artist.
 */
public class SpotifyChart {

    private int rows = 200;   
    private int columns = 3; 
    private String[][] chart = new String[rows][columns];  
    private String[] artist = new String[rows];  
    private String[][] nonRepeatArtist = new String[131][2];

    /**
     * The constructor reads the CSV file data and stores into a two dimensional array.
     * @throws IOException If file is not found.
     */
    public SpotifyChart() throws IOException {

        Scanner data = new Scanner(new File("SpotifyList11.csv"),"UTF-8");

        try {
            while (data.hasNextLine()) {
                for (int i = 0; i < chart.length; i++) {

                    String[] tokens = data.nextLine().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

                    for (int j = 0; j < chart[i].length; j++) {

                        chart[i][j] = tokens[j];

                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    } //End of constructor.

    /**
     * The populateArtist method, populates the artist array with all the artist data.
     */
    public void populateArtist() {
        for (int i = 0; i < chart.length; i++) {
            artist[i] = chart[i][2];
        }
    }//End of populateArtist.
    
    /**
     * The SortArtist method sorts the artist array in alphabetical order.
     */
    public void SortArtist() {

        int pass, j;

        String hold;

        boolean switched = true;

        for (pass = 0; pass < artist.length - 1 && switched; pass++) {
            switched = false;

            for (j = 0; j < artist.length - pass - 1; j++) {
                if (artist[j].compareToIgnoreCase(artist[j + 1]) > 0) {
                    switched = true;
                    hold = artist[j];
                    artist[j] = artist[j + 1];
                    artist[j + 1] = hold;
                }
            }
        }
    }//End of SortArtist.
    
    /**
     * The duplicateArtist method searches through the artist array and stores
     * all the non-duplicateArtist into an array called nonRepeatArtist.
     */
    public void duplicateArtist() {

        boolean isDuplicate = false;
        int count = 0;

        populateArtist();
        SortArtist();

        for (int i = 0; i < artist.length - 1; i++) {

            if (artist[i].equalsIgnoreCase(artist[i + 1])) {
                isDuplicate = true;
            } else {
                isDuplicate = false;
                nonRepeatArtist[count][0] = Integer.toString(count);
                nonRepeatArtist[count][1] = artist[i];
                count++;
            }

        }

    }//End of duplicateArtist.

    /**
     * The recordList method returns the data in the nonRepeatArtist array.
     * @return nonRepeatArtist array.
     */
    public String[][] recordList() {
        duplicateArtist();
        return this.nonRepeatArtist;
    }//End of recordList.

}//End of SpotifyChart class.
