# COMP3111 Introduction to Software Engineering - Spring 2013 #
## System Requirements for Plan2gather ##
### Plan2gather app needs to provide the following functionalities: ###
  * [1. Registration](System_Requirment#1._Registration.md)
  * [2. Main Page - Embedded Calendar](System_Requirment#2._Main_Page_-_Embedded_Calendar.md)
  * [3. Noticeboard](System_Requirment#3._Noticeboard.md)
  * [4. Socle](System_Requirment#4._Socle.md)
  * [5. Profile](System_Requirment#5._Profile.md)
  * [6. Setting](System_Requirment#6._Setting.md)

---


System Specification

Plan2gather is only available under Android version of v4.0.3 or above , time zone of GMT +8(Hong Kong) and language setting of English.


---

#### 1. Registration ####

This activity is for user who is first time to use, to welcome and allow them to register with their phone number.

1.1. Start “Plan2gather”.

1.2. Enter country code and phone number, then tap OK to send user the verification SMS.

1.3. Enter the verification code received via SMS and tap Next. If the verification SMS does not arrive after 5 minutes, tap "Resend Verification Code".

1.4. Error message shall pop up if the entered verification code is incorrect. User should re-enter the code.

1.5. The system allows user enter the code for 5 times. After 5 times, it shall pop up a warning message.

1.6. User can either choose "Exit" to exit the app or "Resend Verification Code".

1.7. Enter the display name and a profile photo if the user wish to do so, then tap "Register".

1.8. User can change their name and profile photo in the setting page anytime.

1.9. After the registration process, the system shall turn to the event main page.


---

After registration, user shall go to the main page.

There are two button that user can see in very page - **slide bar** button on the upper left corner and the **function button** on the upper right corner.

**Slide Bar**

  * The slide bar is on the left hand side which allow user to change from page to page.

  * User can either slide the left side of the monitor or tap the upper left button to use it.

  * Inside the Slide Bar:
  * Calendar (refer to 2)
  * Socle       (refer to 4)
  * Profile     (refer to 5)
  * Setting    (refer to 6)

**Function button**

  * The function button is on the right upper corner of each page.

  * Tap the function button shall pop up the function list which consist of a list of function and is different in different page.


---


#### 2. Main Page - Embedded Calendar ####

This activity allows user to organise all the events in a monthly calendar and this can also connect to Google Calendar for synchronisation.

**Main Page**

2.1. The default page shows the current month.

2.2. User can go to the previous or next month by tapping < or > on the top of the calendar.

2.3. User can select a day and all the events on that day shall show at the bottom notification area.

2.4. If user further select an event on the day list, the system shall turn to the **Noticeboard**(refer to 3) of that event.


**Right Function button in the main page**

This function button include create event, show events in list view, synchronise with google calendar.

**2.5. Create new event**

2.5.1. Choose the event type, including sports, meeting, shopping, dating or the user can create a new type of event.

2.5.2. Enter the following information. If the time and place not yet decided, it is allowed to leave it blank.

2.5.2.1. Name

  * Enter in the typing area to change the event name.

2.5.2.2. Time

  * Change starting and ending date by rolling up or down the day, month and year boxes. The default day should be set as current date. Setting a past date would not be allowed.
  * Change starting and ending time by rolling up or down the hour, minute and  am/pm boxes. The time is based on Hong Kong time zone(GMT+8:00). The default starting time would be the current time and default ending time would be one hour after the current time.

2.5.2.3. Repetition

  * There are five options:
    1. One-time event
    1. Daily
    1. Weekly
    1. Monthly
    1. Yearly

> The default option is one-time event.For weekly, monthly and  yearly, they are based on  the selected starting date. For example, if the starting date is 25/2/2014 (Tue), these options should be displayed as: Weekly (every Tue), Monthly(on day 25) and Yearly (on 25/2) respectively.

2.5.2.4. Participant

  * To add new participant, tap the “add” bar below the present participant. Then choose the person you want to add from the contact list. User can also select a socle in order to add a group of friends instantly. The upper limit of participant is 50.
  * To delete an individual participant or a particular socle, hold the item for 2 seconds. A new menu shall be shown and select “delete” to confirm.

2.5.2.5. Location
  * Choosing the location by either entering the address in the upper search bar or pin it in the map.

2.5.3. Tap Finish.

**2.6. Change from Calendar view to list view**

2.6.1. Tap “List”, the events shall  sort in list view.

2.6.2. Select an event, the system shall turn to the **Noticeboard**(refer to 3) of that event.

2.6.3. Right function button in the list view page include show create event, events in calendar view, synchronise with google calendar.

**2.7. Synchronise with google calendar"**

2.7.1. Tap "Syn", then all your events that saved in google calendar shall show on the the calendar.


---


#### 3. Noticeboard ####

This activity allows user to view or edit the individual **event information** and access to **chat room**.

3.1. The following **event information** shall be shown on the board:
  * Event Name
  * Time
  * Place
  * Participant

**Right Function button in noticeboard page**

This function button include edit.

**3.2. Edit**

This allows user to edit the event information (refer to 2.5.2).

**The "Chat" icon at the bottom in the noticeboard page**

This allows user to go to the **Chat Room**.

**3.3. Chat Room**

This activity is to allow users chat with each other Users can send text message, emoji or voice message.

**3.3.1. Chatting**

> 3.3.1.1. Text message
    * Tap the typing area at the middle bottom to show the keyboard.

> 3.3.1.2. Emoji
    * Tap the emoji button at the lower left corner and a list of icons shall be shown.

> 3.3.1.3. Voice message
    * Tap and hold the mic icon until the audio recording has been finished. The message shall be sent automatically when the user release the mic icon. If the user want to cancel instantly, the user should slide left to cancel.

**Right Function button in the Chat Room Page**

This function button is the function box in the chat room which include media-sharing, voting, social media connection and alarm.

**3.3.2. Media-Sharing**

  * Choose “photo” to select a picture from album

  * Choose “video” to select a video from your phone

  * Choose “camera” to capture video or take a photo instantly by phone camera

  * Choose “contact” to send a single or a list of contact number saved on your phone.

  * Choose “location” to send the current location or a specific location found on Google Map.

**3.3.3. Voting**

This activity allows users to vote for their desire time and location.

> 3.3.3.1. **Deadline** shows the end time for voting.
    * Tap “Deadline” to change the time to vote. It is set as the event day by default. Before the deadline, participants can free to change their choice.

> 3.3.3.2. **Time** shows the desired event holding time.
    * Vote for the time that suggest by other participants by tapping the "tick" at the end of that time.
    * Or add a new event time by choosing from the calendar.
    * The number of vote is shown under each suggested time.

> 3.3.3.3. **Location** shows the desired event holding location
    * Vote for the location that suggest by other participants by tapping the "tick" at the end of that place.
    * Or add a new event location by choosing from the by either entering the address in the upper search bar or pin it in the map.
    * The number of vote is shown under each suggested location.

**3.3.4. Social networking connection**

This activity allows user to share the event to social networking websites including Facebook, Twitter and Weibo.

> 3.3.4.1. Tap “Facebook”, “Twitter” or “Weibo”. If a particular application is not installed in users’ mobile, that application would not be displayed on the list.

> 3.3.4.2. Approve the access of privacy of Plan2gather connect to the chosen social networking platform.Enter the account information (email or user id and password) to log in.

> 3.3.4.3. Confirmation of sharing

**3.3.5. Alarm**

This activity allows users to set alarm for reminder.

> 3.3.5.1. Choose the desire time by rolling the up or down the hour, minute and am/pm boxes.

> 3.3.5.2. Tap “ Ringtone” to choose the favourite ringtone stored in your phone.

> 3.3.5.3. Adjust the loudness in the voice control bar.

> 3.3.5.4. Tap “finish” to confirm


---


#### 4. Socle ####

This activity allows users to create their favourite or frequently used group. Let users add new friends.

The Socle List is shown in the Socle Main Page.

4.1. A socle list is sorted by alphabetic order of the group name as default

4.2. Tap inside each group to see the group members

**Right function button in the individual socle group page**

This function button include Search, find Common time.

**4.2.1. Search**

> 4.2.1.1. Type in the typing area at the bottom to find a member immediately

**4.2.2. Common Time**

> 4.2.2.1. Select the period of time (within one week, one month, three months or half year)

> 4.2.2.2. Select the duration(one hour, two hour, four hour or whole day), select morning or afternoon.

> 4.2.2.3. Tap ”ok” to continue.

> 4.2.2.4. The system shall return the common timeslot that most members are available.

> 4.2.2.5. Tap the given timeslot to create event in this period, and the system shall go to the create event page (2.5).

**Right function button in the socle main page**

This function button include Create Socle, Contact list, Sorting.

**4.3 Create Socle**

> 4.3.1. Enter the Socle name. User can either choose the some default Socle name in the system (family, colleagues, classmates, relatives, sisters, brothers ) or enter their own favourite name.

> 4.3.2. Add members from contact list.

> 4.3.3. Tap finish to add.

**4.4. Contact List**

Show all the friends that user has in Plan2gather in alphabetical order.

**Right function button in contact page**

This function button include add contact, socle, search.

**4.4.1. Add Contract**

> 4.4.1.1. Allow Plan2gather to access user’s contact list from phone.

> 4.4.1.2. If user allow contact access, add people which has this app from contact list, tap finish to add.

> 4.4.1.3. If user does not allow access, add people directly by entering their phone number in the top typing bar. Error message pop up if the entered phone number has not installed Plan2gather. Choose “Invited to Join” or “Retype”.

**4.4.2. Socle**

> 4.4.2.1. Back to Socle Main Page.

**4.4.3. Search**

> 4.4.3.1. Type in the typing area at the bottom to find your friend in this app immediately

**4.5. Sorting**

> 4.5.1.choose the sorting by size of socle, the frequent of use or date of creation.


---


#### 5. Profile ####

This activity allows users to change their customize profile.

**5.1. Change profile picture**

> 5.1.1. Tap the current photo to change the display profile picture, tap choose from “Album” or “From camera”.

> 5.1.2. Select the desired photo or take photos instantly.

> 5.1.3. Tap “Finish” to continue.

**5.2. Change name**

> 5.2.1. Tap the current display name to change name.

> 5.2.2. Type in the typing area


---


#### 6. Setting ####

This activity allows users to change the application behaviour.

**6.1. Notification Setting**

> 6.1.1. Tap in to set whether show the all or individual group new updates, new information or not .

**6.2. Chat Setting**

> 6.2.1. Tap “Text Size” to change the text size from 8pt to 20 pt.

> 6.2.2. Tap “change Wallpaper to change the chatting page wallpaper, tap choose from “Album” or “From camera”.

> 6.2.3. Swipe “Save Incoming Media” to choose whether automatically save images and video that you receive into the Camera Roll.

**6.3. Tell a Friend**

> 6.3.1. Tap to send invite friend to use Plan2gather through message or email

**6.4. Network status**

> 6.4.1. Tap to check the current connection status (connected or disconnected)

**6.5. System Status**

> 6.5.1. Tap to check the current server status

**6.6. Clear all Event**

> 6.6.1. Tap to delete all event in the list

**6.7. Clear all Content**

> 6.7.1. Tap to delete all content