package bitinterleave;

class MortonZCurve {

	static UInt32 EncodeM2D(UInt32 x, UInt32 y) {
		return Expand1((byte) ((new UInt32(y.byteValue() << 1).longValue() + new UInt32(
				x.byteValue()).longValue())));

	}

	static UInt32 EncodeM3D(UInt32 x, UInt32 y, UInt32 z) {

		return

		new UInt32(

		(byte) (Expand2(z.byteValue()).byteValue() << 2) +

		(byte) (Expand2(y.byteValue()).byteValue() << 1) +

		(byte) (Expand2(x.byteValue()).byteValue()));

	}

	static UInt32 Shrink1(byte x) {

		x &= 0x55555555;
		x = (byte) ((x ^ (x >> 1)) & 0x33333333);

		x = (byte) ((x ^ (x >> 2)) & 0x0f0f0f0f);

		x = (byte) ((x ^ (x >> 4)) & 0x00ff00ff);

		x = (byte) ((x ^ (x >> 8)) & 0x0000ffff);

		return new UInt32(x);
	}

	static UInt32 Shrink2(byte x) {

		x &= 0x09249249;
		x = (byte) ((x ^ (x >> 2)) & 0x030c30c3);

		x = (byte) ((x ^ (x >> 4)) & 0x0300f00f);

		x = (byte) ((x ^ (x >> 8)) & 0xff0000ff);

		x = (byte) ((x ^ (x >> 16)) & 0x000003ff);

		return new UInt32(x);
	}

	static UInt32 Expand1(byte x) {

		x &= 0x0000ffff;
		x = (byte) ((x ^ (x << 8)) & 0x00ff00ff);

		x = (byte) ((x ^ (x << 4)) & 0x0f0f0f0f);

		x = (byte) ((x ^ (x << 2)) & 0x33333333);

		x = (byte) ((x ^ (x << 1)) & 0x55555555);

		return new UInt32(x);
	}

	static UInt32 Expand2(byte x) {

		x &= 0x000003ff;
		x = (byte) ((x ^ (x << 16)) & 0xff0000ff);

		x = (byte) ((x ^ (x << 8)) & 0x0300f00f);

		x = (byte) ((x ^ (x << 4)) & 0x030c30c3);

		x = (byte) ((x ^ (x << 2)) & 0x09249249);

		return new UInt32(x);
	}

	static UInt32 DecodeM2X(UInt32 code) {
		return Shrink1((byte) (code.byteValue() >> 0));
	}

	static UInt32 DecodeM2Y(UInt32 code) {
		return Shrink1((byte) (code.byteValue() >> 1));
	}

	// ////
	public static short toUnsigned(byte b) {
		return (short) (b & 0xff);
	}

	public static byte toSigned(short i) {
		return (byte) i;
	}

	// /////
	static UInt32 DecodeM3X(UInt32 code) {
		return Shrink2((byte) (code.byteValue() >> 0));
	}

	static UInt32 DecodeM3Y(UInt32 code) {
		return Shrink2((byte) (code.byteValue() >> 1));

	}

	static UInt32 DecodeM3Z(UInt32 code) {
		return Shrink2((byte) (code.byteValue() >> 2));
	}

}