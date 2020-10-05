/**
 * @author Yaaqov Shkifati
 * @Since 9/31/2020
 * @verison 1.0
 */
package spotifychart;

import java.io.IOException;
import java.io.PrintStream;

/**
 * The Artist class is a node that represents an artist.
 */
public class Artist {

    private String name;
    private Artist next;

    /**
     * The constructor initializes the name of the artist.
     * @param name Artist.
     */
    public Artist(String name) {
        this.name = name;
    }//End of constructor.

    /**
     * The node method returns the data stored in the node.
     * @return Artist name.
     */
    public String Node() {
        return name;
    }//End of the node class.
    
    /**
     * The TopStreamingArtists extends the SpotifyChart class and adds the artist
     * name to a new node.
     */
    public static class TopStreamingArtists extends SpotifyChart {

        private Artist first;
        private PrintStream output;
        
        /**
         * The constructor initializes the position of the first node and instantiate
         * an output file.
         * @throws IOException if file not found.
         */
        public TopStreamingArtists() throws IOException {
            first = null;
            output = new PrintStream("ArtistsSorted-10.05.2020.txt");

        }//End of constructor.
        
        /**
         * The isEmpty class checks to see if the link list is empty.
         * @return if empty.
         */
        public boolean isEmpty() {
            return (first == null);
        }//End of isEmpty.
        
        /**
         * Adds a new node to the linked list.
         * @param name Artist.
         */
        public void addNode(String name) {

            Artist sortedName = new Artist(name);
            sortedName.next = first;
            first = sortedName;
        }//End of addNode.
        
        /**
         * Prints the data of the link lists into a file.
         * @throws IOException 
         */
        public void displayList() throws IOException {

            Artist current = first;

            this.output.println("Artist Names In Alphabetical Order:");
            this.output.println("----------------------------------");

            while (current != null) {

                this.output.println(current.Node());
                current = current.next;
            }
            
            output.close();
        }//End of displayList.
        
        /**
         * The transferList method returns the nonRepeatArtist array from the super class.
         * @return nonRepeatArtist 2D array.
         */
        public String[][] transferList() {
            return super.recordList();
        }//end of transferList.

        public static void main(String[] args) throws IOException {

            //instantiating 
            TopStreamingArtists artistName = new TopStreamingArtists();
             
            //adding all the nodes.
            for (int i = artistName.transferList().length - 1; i >= 0; i--) {

                String addDataToNodes = artistName.transferList()[i][0] + ". "
                        + artistName.transferList()[i][1];

                artistName.addNode(addDataToNodes);
            }
            
            artistName.displayList(); // Printing all the nodes.

        }  //End of main method.
    }  //End of TopStreamingArtist class.
}  //End of Artist class.
