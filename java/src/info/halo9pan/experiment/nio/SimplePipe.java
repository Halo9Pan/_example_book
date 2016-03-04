/**
 * The MIT License (MIT)
 * 
 * Copyright (c) 2016 Halo9Pan
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package info.halo9pan.experiment.nio;

/**
 * @author Halo9Pan
 *
 */
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class SimplePipe {
	public static void main(String[] args) throws IOException {

		// An instance of Pipe is created
		Pipe pipe = Pipe.open();

		// gets the pipe's sink channel
		Pipe.SinkChannel skChannel = pipe.sink();

		String testData = "Test Data to Check java NIO Channels Pipe.";

		ByteBuffer buffer = ByteBuffer.allocate(512);
		buffer.clear();
		buffer.put(testData.getBytes());

		buffer.flip();
		// write data into sink channel.
		while (buffer.hasRemaining()) {
			skChannel.write(buffer);
		}
		// gets pipe's source channel
		Pipe.SourceChannel sourceChannel = pipe.source();
		buffer = ByteBuffer.allocate(512);

		// write data into console
		while (sourceChannel.read(buffer) > 0) {

			// limit is set to current position and position is set to zero
			buffer.flip();

			while (buffer.hasRemaining()) {
				char ch = (char) buffer.get();
				System.out.print(ch);
			}

			// position is set to zero and limit is set to capacity to clear the buffer.
			buffer.clear();
		}

	}
}