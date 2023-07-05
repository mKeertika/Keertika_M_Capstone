# Keertika_M_Capstone

DEPENDENCIES ADDED:
1.spring-boot-starter-test
2. spring-boot-starter-data-jpa
3. spring-boot-starter-thymeleaf
4. spring-boot-starter-web
5. mysql-connector-j
6. spring-boot-starter-actuator


#############################################################################3
HTML FILES DETAILS
This is simple Static html website.
which is describing basic connectivity of blog pages.
I used Bootstrap, inline CSS, internal CSS, internal javascript as well.

home page:
home page has blog list
top menu to navigate the pages

inner page:
describes details blog page with comment box

contact us:
this page has basic contact us form with form constraints in javascript.

about us:
it has little description about me.

footer:
footer part of each pages has social media linkGIT 

regular signup and login page


##############################################
user:
@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private String username;
    
    private String email;
    
    private String password;
    
    // Constructors, getters, and setters
}

########################################################

@Entity
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private String title;
    
    @Lob
    private String content;
    
    @ManyToOne
    private User author;
    
    private LocalDateTime publicationDate;
    
    // Constructors, getters, and setters
}

###########################################################
@Entity
public class Comment {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private String commenterName;
    
    @Lob
    private String content;
    
    private LocalDateTime commentDate;
    
    @ManyToOne
    private Post userPost;
    
    // Constructors, getters, and setters
}

############################################################
@Entity
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private String name;
    
    private String description;
    
    @ManyToMany(mappedBy = "categories")
    private List<Post> posts;
    
    // Constructors, getters, and setters
}

#####################################################S