object Library extends App {
  // Book definition
  case class Book(title: String, author: String, isbn: String)
  var books: Set[Book] = Set()

  // Library Management
  def addBook(title: String, author: String, isbn: String): Set[Book] = {
    val newBook: Book = Book(title, author, isbn)
    books += newBook
    println(s"$title added to the library")
    books
  }

  def removeBook(isbn: String): Set[Book] = {
    books.find(_.isbn == isbn) match {
      case Some(book) =>
        books -= book
        println(s"${book.title} removed from the library")
      case None =>
        println(s"Book with ISBN $isbn not found in the library")
    }
    books
  }

  def checkBook(isbn: String): Unit = {
    if (books.exists(_.isbn == isbn)) {
      println(s"Book with ISBN $isbn is already in the Library!")
    } else {
      println(s"Book with ISBN $isbn is Not in the Library!")
    }
  }

  def displayBooks(): Unit = {
    println("\n---------=====[Library]=====----------")
    println("[Book Title]\t\t[Author]\t\t[ISBN]")
    for (book <- books) {
      println(s"${book.title}\t\t${book.author}\t\t${book.isbn}")
    }
    println()
  }

  def searchBookByTitle(title: String): Unit = {
    val foundBooks = books.filter(_.title == title)
    if (foundBooks.nonEmpty) {
      for (book <- foundBooks) {
        println(s"$title----------------------------")
        println(s"Author: ${book.author}\nISBN: ${book.isbn}")
      }
    } else {
      println(s"$title is Not in the Library!")
    }
  }

  // Add 3 books
  addBook("Harry Potter", "J.K.Rowling", "Book1")
  addBook("Matilda", "Roald Dahl", "Book2")
  addBook("Career of Evil", "J.K.Rowling", "Book3")
  displayBooks()

  // Check the isbn = book2 is there
  checkBook("Book2")

  // Remove a book
  removeBook("Book2")
  displayBooks()

  // Search by title
  searchBookByTitle("Harry Potter")
}
