package bitinterleave;

public class InterleaveClient {

	public static void main(String[] args) {

		MortonZCurve m = new MortonZCurve();

		UInt32 test = m.EncodeM3D(new UInt32(7), new UInt32(2), new UInt32(3));

		System.out.println(m.DecodeM3X(test).longValue());

	}

}
