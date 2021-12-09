Demo of entities design

-- Many to many approach
Customer
private Long id;
private String name;
private LocalDate regDate;
private String Email;
@OneToMany(mappedBy = "customer")
private List<Cart> carts;

Cart
private Long id;
private LocalDate date;
@ManyToOne
private Customer customer;
@ManyToMany(mappedBy = "carts")
private List<Product> products;

Product
private Long id;
private String name;
private double price;
@ManyToMany
private List<Cart> carts;



--Using intermediate table
Customer
private Long id;
private String name;
private LocalDate regDate;
private String Email;
@OneToMany(mappedBy = "customer")
private List<Cart> carts;

Cart
private Long id;
private LocalDate date;
@ManyToOne
private Customer customer;
@OneToMany(mappedBy = "carts")
private List<Product_Cart> products;

Product
private Long id;
private String name;
private double price;
@OneToMany
private List<Product_Cart> carts;

Product_Cart
private Long id;
private Cart cart;
private Product product;
private int quantity;
private double discount;