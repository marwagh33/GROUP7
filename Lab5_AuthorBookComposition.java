/**
 * Lab 5: Author and Book - Composition (Has-A Relationship)
 * PT821 - Object-Oriented Programming
 * State University of Zanzibar (SUZA)
 *
 * LEARNING OBJECTIVES:
 * - Understand composition ("has-a") vs inheritance ("is-a")
 * - Create classes that contain objects of other classes
 * - Access composed object properties through delegation
 * - Compare when to use composition vs inheritance
 *
 * KEY CONCEPT:
 * A Book HAS-A Author (composition)     -- NOT "A Book IS-A Author" (inheritance)
 * A Book is COMPOSED OF an Author        -- The Author is a PART of the Book
 *
 * INSTRUCTIONS:
 * Complete the following exercises step by step.
 * Follow the TODO comments and implement the required functionality.
 */

// ============================================================
// PART A: The Author Class
// ============================================================
class Author {

    // Private instance variables
    private String name;
    private String email;
    private char gender;

    // Constructor
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    // Setter (only for email)
    public void setEmail(String email) {
        this.email = email;
    }

    // toString method
    @Override
    public String toString() {
        return "Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
    }
}


// ============================================================
// PART B: The Book Class (composes Author)
// ============================================================

class Book {

    // Private instance variables
    private String name;
    private Author author;   // Composition (Book HAS-A Author)
    private double price;
    private int qty;

    // Constructor 1 (qty defaults to 0)
    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = 0;
    }

    // Constructor 2
    public Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    // Setters
    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    // Delegation methods (Accessing composed object)
    public String getAuthorName() {
        return author.getName();
    }

    public String getAuthorEmail() {
        return author.getEmail();
    }

    public char getAuthorGender() {
        return author.getGender();
    }

    // toString method
    @Override
    public String toString() {
        return "Book[name=" + name + ", " + author.toString()
                + ", price=" + price + ", qty=" + qty + "]";
    }
}

// ============================================================
// PART C: Test Driver
// ============================================================

public class Lab5_AuthorBookComposition {
    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("  Lab 5: Author and Book (Composition)");
        System.out.println("=============================================\n");

        // ----- Section 1: Author Objects -----
        System.out.println("--- Section 1: Creating Authors ---");

        Author author1 = new Author("Ali Sultan", "ali.sultan@suza.ac.tz", 'm');
        Author author2 = new Author("Mwanaisha Bakari", "mwanaisha.b@suza.ac.tz", 'f');
        Author author3 = new Author("Hamad Khamis", "hamad.k@gmail.com", 'm');
        //
         System.out.println(author1);
         System.out.println(author2);
         System.out.println(author3);

        // ----- Section 2: Book Objects (Composition) -----
        System.out.println("\n--- Section 2: Creating Books ---");

        Book book1 = new Book("Introduction to Java", author1, 35000, 50);
        Book book2 = new Book("Data Structures in Java", author2, 42000, 30);

        System.out.println(book1);
        System.out.println(book2);

        // ----- Section 3: Accessing Composed Object -----
        System.out.println("\n--- Section 3: Accessing Through Composition ---");

        System.out.println("Book: " + book1.getName());
        System.out.println("Author name: " + book1.getAuthorName());     // Delegated
        System.out.println("Author email: " + book1.getAuthorEmail());   // Delegated
         
        //// You can also get the Author object directly
         Author bookAuthor = book1.getAuthor();
        System.out.println("Author object: " + bookAuthor);

        // ----- Section 4: Shared References -----
        System.out.println("\n--- Section 4: Shared Author References ---");

        Book book3 = new Book("Advanced Java Programming", author1, 55000, 20);
        System.out.println("Book 1 author: " + book1.getAuthorName());
        System.out.println("Book 3 author: " + book3.getAuthorName());
        System.out.println("Same author? " + (book1.getAuthor() == book3.getAuthor()));

        // // What happens when we change the shared author's email?
        author1.setEmail("ali.sultan.new@suza.ac.tz");
        System.out.println("\nAfter changing author1's email:");
        System.out.println("Book 1 author email: " + book1.getAuthorEmail());
        System.out.println("Book 3 author email: " + book3.getAuthorEmail());
        System.out.println("Both changed! Because they share the same Author object.");

        // ----- Section 5: Anonymous Author -----
        System.out.println("\n--- Section 5: Creating Book with Anonymous Author ---");

        Book book4 = new Book(
                  "Python for Beginners",
             new Author("Salma Haji", "salma.h@suza.ac.tz", 'f'),
            28000,
             100
        );
        System.out.println(book4);
        System.out.println("Author: " + book4.getAuthorName());

        // ----- Section 6: Book Inventory -----
        System.out.println("\n--- Section 6: Book Inventory ---");


        Book[] inventory = {book1, book2, book3, book4};
        
        System.out.println("SUZA Bookshop Inventory:");
        System.out.println(String.format("%-30s %-25s %10s %5s",
             "Title", "Author", "Price(TZS)", "Qty"));
        System.out.println("-".repeat(75));
        
        double totalValue = 0;
        for (Book book : inventory) {
            System.out.println(String.format("%-30s %-25s %,10.0f %5d",
                book.getName(), book.getAuthorName(),
                book.getPrice(), book.getQty()));
            totalValue += book.getPrice() * book.getQty();
         }
        System.out.println("-".repeat(75));
        System.out.println(String.format("Total inventory value: TZS %,.0f", totalValue));

        System.out.println("\n=============================================");
        System.out.println("  End of Lab 5");
        System.out.println("=============================================");
    }
}

/*
 * EXPECTED OUTPUT (after completing all TODOs):
 *
 * =============================================
 *   Lab 5: Author and Book (Composition)
 * =============================================
 *
 * --- Section 1: Creating Authors ---
 * Author[name=Ali Sultan, email=ali.sultan@suza.ac.tz, gender=m]
 * Author[name=Mwanaisha Bakari, email=mwanaisha.b@suza.ac.tz, gender=f]
 * Author[name=Hamad Khamis, email=hamad.k@gmail.com, gender=m]
 *
 * --- Section 2: Creating Books ---
 * Book[name=Introduction to Java, Author[name=Ali Sultan, email=ali.sultan@suza.ac.tz, gender=m], price=35000.0, qty=50]
 * Book[name=Data Structures in Java, Author[name=Mwanaisha Bakari, email=mwanaisha.b@suza.ac.tz, gender=f], price=42000.0, qty=30]
 *
 * --- Section 3: Accessing Through Composition ---
 * Book: Introduction to Java
 * Author name: Ali Sultan
 * Author email: ali.sultan@suza.ac.tz
 * Author object: Author[name=Ali Sultan, email=ali.sultan@suza.ac.tz, gender=m]
 *
 * --- Section 4: Shared Author References ---
 * Book 1 author: Ali Sultan
 * Book 3 author: Ali Sultan
 * Same author? true
 *
 * After changing author1's email:
 * Book 1 author email: ali.sultan.new@suza.ac.tz
 * Book 3 author email: ali.sultan.new@suza.ac.tz
 * Both changed! Because they share the same Author object.
 *
 * --- Section 5: Creating Book with Anonymous Author ---
 * Book[name=Python for Beginners, Author[name=Salma Haji, ...], ...]
 * Author: Salma Haji
 *
 * --- Section 6: Book Inventory ---
 * SUZA Bookshop Inventory:
 * Title                          Author                        Price(TZS)   Qty
 * ---------------------------------------------------------------------------
 * Introduction to Java           Ali Sultan                     35,000    50
 * Data Structures in Java        Mwanaisha Bakari               42,000    30
 * Advanced Java Programming      Ali Sultan                     55,000    20
 * Python for Beginners           Salma Haji                     28,000   100
 * ---------------------------------------------------------------------------
 * Total inventory value: TZS 6,810,000
 *
 * QUESTIONS TO ANSWER:
 * 1. What is the difference between composition (has-a) and inheritance (is-a)?
 * Ans:composition: one class contains another class as a part of it WHILE Inhertance:One class is a type of another class Example: Book has an Author. Example: Dog extends Animal → Dog IS-A Animal. whle 
 * 
 * 2. Why is it better for Book to HAVE an Author rather than EXTEND Author?
 * Ans: Because book contain author and it is not type of author
 * 
 * 
 * 3. In Section 4, why does changing author1's email affect both books?
 *    How could you prevent this? (Hint: think about deep copy vs shallow copy)
 *    Ans: Because both books store a reference to the same Author object
 *    
 *    
 * 4. Can an Author exist without a Book? Can a Book exist without an Author?
 * Ans:YES
 *    What does this tell you about the strength of the composition relationship?
 *    A Book depends on Author to exist.
 *
 * SUBMISSION:
 * - Complete all TODO sections (create Author and Book classes + uncomment test code)
 * - Answer all questions above in comments
 * - Submit the completed .java file
 */
