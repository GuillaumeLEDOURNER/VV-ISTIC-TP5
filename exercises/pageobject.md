## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

```java=
import java.util.List;

public interface ProjetQuickstartPage {

    // Button line at top
    void clickNewButton();

    void clickShareButton();

    void clickChatButton();

    void clickPadButton();

    // Participant Information
    String getName();

    void setName(String newName);

    String getEmail();

    void setEmail(String newName);

    String getAgenda();

    void setAgenda(boolean value);

    String getMealPreference();

    void setMealPreference(boolean value);

    //Time Selector
    void clickCalendarView();

    void clickTableView();

    void checkTimeByDate(List<String> l );

    void uncheckTimeByDate(List<String> l );

    void getParticpantNameInview();

    void clickSubmitButton();

    // Comment section
    String getCommentAuthor();

    void setCommentAuthor(String newName);

    String getComment();

    void getComment(String newComment);

    void clickAddComment();

}
```
