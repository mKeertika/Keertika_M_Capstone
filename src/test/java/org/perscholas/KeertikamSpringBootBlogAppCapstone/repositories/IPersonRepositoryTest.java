//package org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories;
//
//
//import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.Person;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.testng.annotations.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@DataJpaTest
//public class IPersonRepositoryTest {
//    @MockBean
//    private IPersonRepository userRepository;
//
//    @Test
//    public void testFindFirstByUserName_ExistingUserName_ReturnsUser() {
//        // Arrange
//        String userName = "testUser";
//        Person expectedPerson = new Person();
//        expectedPerson.setUserName(userName);
//        when(userRepository.findFirstByUserName(userName)).thenReturn(expectedPerson);
//
//        // Act
//        Person actualPerson = userRepository.findFirstByUserName(userName);
//
//        // Assert
//        assertEquals(expectedPerson, actualPerson);
//    }
//}
//
