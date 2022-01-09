# Study Session Journal App

![book](https://user-images.githubusercontent.com/31045221/148676257-29ad65ce-1376-450a-840b-3d6a7d726913.png)

<b> Problem Statement: </b>

Many students, be it a college student or someone who's learning or preparing for anything want to manage their time efficiently and to have regular study sessions consistently. However, all this can be overwhelming if they're not tracking their progress and how they are managing with how much time they are commiting to it.

<b> Proposed Solution : </b>

This project proposes a “Study Session Journal App” to keep track of your studies. The app allows you to click on the start button when you are starting a study session and to press on the stop button when the session ends. Through the session you will be able to track how much time you have dedicated and in the end you will also be able to rate the productivity of your session (1-5). The data is stored using room database and will be available even if you close the app.

Screenshots:
![WhatsApp Image 2022-01-09 at 3 45 00 AM](https://user-images.githubusercontent.com/31045221/148676246-70758c56-4106-4518-ba84-d16e607719ee.jpeg)
![WhatsApp Image 2022-01-09 at 3 45 00 AM (1)](https://user-images.githubusercontent.com/31045221/148676248-2c9eb693-c726-487e-be07-f12301c7b2e1.jpeg)
![WhatsApp Image 2022-01-09 at 3 45 00 AM (2)](https://user-images.githubusercontent.com/31045221/148676249-c52288f2-531e-441b-822f-2829b0b9b0ff.jpeg)


<b> Functionality & Concepts used : </b>

- The App has a very simple and interactive interface which helps the students track their study session interactively. Following are few android concepts used to achieve the functionalities in app : 
- Constraint Layout : Most of the activities in the app uses a flexible constraint layout, which is easy to handle for different screen sizes.
- Simple & Easy Views Design : Use of familiar audience EditText with hints and interactive buttons made it easier for students to register or sign in without providing any detailed instructions pages. Apps also uses App Navigation to switch between different screens.
- RecyclerView : To present the list of all the study sessions we used the efficient recyclerview.
- LiveData & Room Database : We are also using LiveData to update & observe any changes in the study sessions from their mobile at real time and update it to local databases using Room.

<b> Application Link & Future Scope : </b>

The App is currently being circulated among the students of UIT RGPV Bhopal and we are collecting their feedbacks. A lot of improvements can be made and the app can then later be also published on Google Play Store.
The APK is currently available at [Google Drive](https://drive.google.com/file/d/1soWmbUJkElj41O6h0fvvrvBMlxAtfFxy/view?usp=sharing) and the code in this repository only.
