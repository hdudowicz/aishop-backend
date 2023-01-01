package com.hddev.aishopcore.utils

import java.io.ByteArrayOutputStream
import java.net.URL
import javax.imageio.ImageIO

object ImageUtils {
    fun downloadImageFromUrl(url: String): ByteArray {
        val imageUrl = URL(url)

        val image = ImageIO.read(imageUrl)

        val outputStream = ByteArrayOutputStream()
        ImageIO.write(image, "jpg", outputStream)
        return outputStream.toByteArray()
    }
}