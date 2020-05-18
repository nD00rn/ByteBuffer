package com.github.nd00rn.bytebuffer

import java.util.stream.Collectors

class ByteBuffer : ArrayList<Byte> {

    /**
     * Default constructor
     */
    constructor()

    /**
     * Constructor with byte array
     */
    constructor(input: ByteArray) {
        this.add(input)
    }

    /**
     * Constructor with byte buffer
     */
    constructor(input: ByteBuffer) {
        this.add(input)
    }

    /**
     * Constructor with byte
     */
    constructor(input: Byte) {
        this.add(input)
    }

    /**
     * Constructor with int
     */
    constructor(input: Int) {
        this.add(input)
    }

    /**
     * Adds an int value to the buffer
     */
    fun add(input: Int): ByteBuffer {
        this.add(input.toByte())

        return this
    }

    /**
     * Adds an byte array to the buffer
     */
    fun add(input: ByteArray): ByteBuffer {
        input.forEach { b -> this.add(b) }

        return this
    }

    /**
     * Adds an byte array to the buffer
     */
    fun add(input: Array<Byte>): ByteBuffer {
        this.addAll(input)

        return this
    }

    /**
     * Adds a byte buffer to the buffer
     */
    fun add(input: ByteBuffer): ByteBuffer {
        this.add(input.toByteArray())

        return this
    }

    /**
     * Adds a byte multiple times to the buffer
     */
    fun addRepeat(input: Byte, count: Int): ByteBuffer {
        repeat(count) { this.add(input) }

        return this
    }

    /**
     * Adds a int value mutliple times to the buffer
     */
    fun addRepeat(input: Int, count: Int): ByteBuffer {
        repeat(count) { this.add(input) }

        return this
    }

    /**
     * Adds a byte array multiple times to the buffer
     */
    fun addRepeat(input: ByteArray, count: Int): ByteBuffer {
        repeat(count) { this.add(input) }

        return this
    }

    /**
     * Adds a byte array multiple times to the buffer
     */
    fun addRepeat(input: Array<Byte>, count: Int): ByteBuffer {
        repeat(count) { this.add(input) }

        return this
    }

    /**
     * Adds a byte buffer multiple times to the buffer
     */
    fun addRepeat(input: ByteBuffer, count: Int): ByteBuffer {
        repeat(count) {
            this.add(input)
        }

        return this
    }

    /**
     * Get a certain range from the buffer
     */
    fun getRange(first: Int, last: Int): ByteBuffer {
        return ByteBuffer(toByteArray().copyOfRange(first, last))
    }

    /**
     * Convert the buffer to a byte array
     */
    fun toByteArray(): ByteArray {
        return ByteArray(this.size) { i -> this[i] }
    }

    /**
     * Remove the first X number of bytes from the buffer
     */
    fun removeFirst(amount: Int): ByteBuffer {
        return getRange(0, amount).also {
            this.removeRange(0, amount)
        }
    }

    /**
     * Remove the last X number of bytes from the buffer
     */
    fun removeLast(amount: Int): ByteBuffer {
        val last = this.size
        val first = last - amount

        return getRange(first, last).also {
            this.removeRange(first, last)
        }
    }

    /**
     * Print the content of the buffer as a hexadecimal string
     */
    fun toHexString(): String {
        return toFormattedString()
    }

    /**
     * Print the content of the buffer as a hexadecimal string
     */
    fun toHexString(joiner: String): String {
        return toFormattedString(joiner = joiner)
    }

    /**
     * Print the content of the buffer as a string
     */
    fun toFormattedString(joiner: String = " ", format: String = "%02X"): String {
        return this.stream()
                .map { String.format(format, it) }
                .collect(Collectors.joining(joiner))
    }
}
