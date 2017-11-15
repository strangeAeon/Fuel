package com.github.kittinunf.fuel.util

import java.io.BufferedInputStream
import java.io.InputStream

/**
 * Created by woramet on 11/11/17.
 */

class ReusableInputStream(var inputStream: InputStream): InputStream() {

    init {
        if (!inputStream.markSupported()) {
            inputStream = BufferedInputStream(inputStream)
            throw IllegalArgumentException("Marking not supported !")
        }

        println(inputStream.markSupported())
        inputStream.mark(Int.MAX_VALUE)
    }

    override fun read(): Int {
        return inputStream.read()
    }

    override fun read(b: ByteArray?): Int {
        return inputStream.read(b)
    }

    override fun read(b: ByteArray?, off: Int, len: Int): Int {
        return inputStream.read(b, off, len)
    }

    override fun close() {
        inputStream.reset()
    }
}