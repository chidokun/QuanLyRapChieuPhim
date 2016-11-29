package rcp.util;

import java.awt.image.BufferedImage;
import java.io.*;
import org.eclipse.swt.graphics.*;
import javax.imageio.*;

public class Images {
	public static org.eclipse.swt.graphics.Image get(Device device, String source) throws IOException {
		

		ImageData imgData = new ImageData(source);
		return new org.eclipse.swt.graphics.Image(device, imgData);
	}

}
