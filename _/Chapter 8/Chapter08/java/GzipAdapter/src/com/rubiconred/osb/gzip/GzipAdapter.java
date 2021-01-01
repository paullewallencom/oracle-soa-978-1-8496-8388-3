package com.rubiconred.osb.gzip;

import org.apache.xmlbeans.*;
import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipAdapter {
	
	public static XmlObject readGzipObject(Object param) throws IOException, XmlException 
	{
		byte[] bytes = (byte[]) param;
		if (bytes != null) {
			InputStream input = new ByteArrayInputStream(bytes);
			InputStream gzipInput = new GZIPInputStream(input);

			Writer writer = new StringWriter();
			char[] buffer = new char[1024];

			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(gzipInput, "UTF-8"));

				int n;
				while ((n = reader.read(buffer)) != -1)
					writer.write(buffer, 0, n);
			} finally {
				gzipInput.close();
			}

			// return the contents of the file
			return XmlObject.Factory.parse(writer.toString());
		} else {
			// input parameter is null, return null
			return null;
		}
	}

	public static byte[] writeGzipObject(XmlObject input) throws IOException, XmlException 
	{
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		GZIPOutputStream gzipOutput = new GZIPOutputStream(output);

		input.save(gzipOutput);
		gzipOutput.close();

		return output.toByteArray();
	}
}
