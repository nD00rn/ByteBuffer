package com.github.nd00rn.bytebuffer

import org.junit.Assert
import org.junit.Test

class ByteBufferTest {

    @Test
    fun constructors() {
        // Default constructor
        val b1 = ByteBuffer()
        Assert.assertEquals(0, b1.size)

        // Constructor with another ByteBuffer
        val b2 = ByteBuffer(ByteBuffer())
        Assert.assertEquals(0, b2.size)

        // Constructor with an Int
        val b3 = ByteBuffer(1)
        Assert.assertEquals(1, b3.size)
        Assert.assertEquals(1.toByte(), b3[0])

        // Constructor with a Byte
        val b4 = ByteBuffer(0x01.toByte())
        Assert.assertEquals(1, b4.size)
        Assert.assertEquals(1.toByte(), b4[0])
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

        Assert.assertEquals("01 02 03 04 05", hexOutput)
        Assert.assertEquals("001 002 003 004 005", decOutput)
        Assert.assertEquals("""
            01  02  03  04  05
            001 002 003 004 005
        """.trimIndent(), hexDecOutput)
    }
}
