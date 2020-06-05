package com.github.nd00rn.bytebuffer

import org.junit.Test

class ByteBufferTest {

    @Test
    fun constructors() {
        // Default constructor
        val b1 = ByteBuffer()
        assert(b1.size == 0)

        // Constructor with another ByteBuffer
        val b2 = ByteBuffer(ByteBuffer())
        assert(b2.size == 0)

        // Constructor with an Int
        val b3 = ByteBuffer(1)
        assert(b3.size == 1)
        assert(b3[0] == 0x01.toByte())

        // Constructor with a Byte
        val b4 = ByteBuffer(0x01.toByte())
        assert(b4.size == 1)
        assert(b4[0] == 0x01.toByte())
    }

    @Test
    fun toStringTest() {
        val buffer = ByteBuffer().apply {
            add(0x01)
            add(0x02)
            add(0x03)
            add(0x04)
            add(0x05)
        }

        val hexOutput = buffer.toHexString()
        val decOutput = buffer.toDecString()
        val hexDecOutput = buffer.toHexDecString()

        println(hexOutput)
        println(decOutput)
        println(hexDecOutput)

        assert("01 02 03 04 05" == hexOutput)
        assert("001 002 003 004 005" == decOutput)
    }
}
