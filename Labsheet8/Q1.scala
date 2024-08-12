object CaesarCipher {

  // Encrypts the given text using a Caesar cipher with the specified shift
  def encrypt(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val base = if (char.isUpper) 'A' else 'a'
        ((char - base + shift) % 26 + base).toChar
      } else {
        char
      }
    }
  }

  // Decrypts the given text using a Caesar cipher with the specified shift
  def decrypt(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val base = if (char.isUpper) 'A' else 'a'
        ((char - base - shift + 26) % 26 + base).toChar
      } else {
        char
      }
    }
  }

  // General function that applies either encryption or decryption
  def cipher(text: String, shift: Int, algorithm: (String, Int) => String): String = {
    algorithm(text, shift)
  }

  // Example usage
  def main(args: Array[String]): Unit = {
    val plaintext = "Himasha"
    val shift = 3

    // Encrypt the plaintext
    val encryptedText = cipher(plaintext, shift, encrypt)
    println(s"Encrypted: $encryptedText")

    // Decrypt the ciphertext
    val decryptedText = cipher(encryptedText, shift, decrypt)
    println(s"Decrypted: $decryptedText")
  }
}
