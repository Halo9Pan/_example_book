/**
 * Created on Sep 21, 2011
 */
package info.halo9pan.examples.prospring3.ch4;

/**
 * @author Clarence
 *
 */
public interface ArtworkSender {

	public void sendArtwork(String artworkPath, Recipient recipient);

	public String getFriendlyName();

	public String getShortName();

}
