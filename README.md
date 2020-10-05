# Lab-3
Description: The propose of this lab, is to generate a report for a record label company. The report is the top hit music artist names of the last couple of weeks sorted in in alphabetical order.

Instructions: The way we obtain this report goes as following:

First, we downloaded CSV file from spotify webiste. Then we created a Java class called SpotifyChart; that would read the data from the file, sort the artist names in alpalphabetical order, and remove all if any dublicate artist.

Second, We create a second class called Artist that would be a node represents an artist. Then we would create an inner class called TopStreamingArtists, which 
extend the SpotifyChart class, that would enable us to retive the artist data from theSpotifyChart class. Then will add the data of each artist to a new node, starting at the end of artist report because the properties of a linked list: first in last out. Once we finish populating the linked list will send all the data to 
a text file named ArtistsSorted-10.05.2020. 


