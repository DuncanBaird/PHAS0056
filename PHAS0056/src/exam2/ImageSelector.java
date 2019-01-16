package exam2;

import java.util.ArrayList;

/**
 * Interface for selecting images as an ArrarList from an ArrayList of images
 * 
 * @author
 *
 */
public interface ImageSelector {

	public ArrayList<Location> select(ArrayList<Location> locations) throws Exception;

}
