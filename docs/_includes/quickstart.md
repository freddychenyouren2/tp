## Get Started with ToothTracker
Welcome to ToothTracker! We're excited to help you streamline your dental practice with ease.
This quick start guide will walk you through the setup and basic operations of ToothTracker so you can begin optimizing your clinic's workflow right away.

### Installing ToothTracker

Haven't installed ToothTracker yet? Follow our easy step-by-step guide below to get ToothTracker up and running in no time.
Our software is compatible with Windows, macOS, and Linux for optimal performance.


1. ToothTracker requires **Java 11 or above** installed in your Computer to run.
    - If you don't have Java installed, no worries — it's completely free! Find detailed installation instructions [here](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A).

    <div markdown="span" class="alert alert-primary">
      :bulb: **Tip:** Unsure about your Java version? Our [troubleshooting](#troubleshooting) section has you covered with a quick guide.
    </div>
   
1. Grab the latest version of ToothTracker by downloading the `toothtracker.jar` file from our [releases page](https://github.com/AY2324S1-CS2103T-W10-3/tp/releases).

1. Create an empty folder in your computer where you would like to use as the _home folder_ for ToothTracker.

1. Place the downloaded ToothTracker file (`toothtracker.jar`) into the folder.

Installation complete! You're now ready to launch ToothTracker.

### Launching ToothTracker
Great! Now that you have downloaded ToothTracker (if not, refer to the [Installation Instructions](#installation-instructions)), let's get it up and running.

1. Open a command terminal.
2. Enter `cd` and change your working directory into the folder you put the `toothtracker.jar` file in.
3. Enter the `java -jar toothtracker.jar` command to run the application.

A user-friendly GUI will pop up shortly, preloaded with some sample data to get you started.<br>
![Ui](images/Ui.png){: .centered-image }

### Familiarising with ToothTracker's Interface
Now that you have ToothTracker up and running, let's get you familiar with ToothTracker's user interface!

ToothTracker has two windows: a [Main Window](#main-window) and a [Calendar Window](#calendar-window).
Let's take a closer look at each window individually.

{: .no_toc}
#### Main Window
When you first open ToothTracker, the Main Window will open by default.
It's designed to give you a comprehensive overview of all your patient, dentist, and appointment-related information at a glance.
Let's learn what each of these components does!

![ToothTracker UI](images/UiAnnotated.png){: .centered-image-full-size }

|   | Component                   | Description                                                                                                                                                                                            |
|---|-----------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1 | Menu Bar                    | The menu bar contains menu options to [exit](#exiting-the-program-exit) from ToothTracker and access [help](#viewing-help--help) resources.                                                            |
| 2 | Command Input               | The command input is where you can key in your commands to tell ToothTracker what you want to get done. To learn more about ToothTracker's CLI, refer to the [next section](#using-toothtrackers-cli). |
| 3 | Result Display              | The result display area shows you the outcomes or feedback from your entered commands.                                                                                                                 |
| 4 | Patient List                | This panel lists all patients currently registered in your clinic. It includes vital information such as names, contact details, and other fields.                                                     |
| 5 | Dentist List                | Here, you'll find a roster of dentists associated with your clinic, complete with their specializations and contact information.                                                                       |
| 6 | Appointment List            | Check the appointment list for the schedule, status, and details of all clinic appointments.                                                                                                           |
| 7 | [Quick Notes](#quick-notes) | A dedicated space at the bottom of the Main Window for on-the-fly notes, reminders, or observations that you need to keep handy.                                                                       |
| 8 | Saved Data File             | For advanced users, the [file path](#glossary) displayed here is where ToothTracker stores your saved data (which you can [edit](#editing-the-data-file)).                                             |

{: .no_toc}
#### Quick Notes
Quick Notes is designed to enhance your efficiency by providing a space for immediate note-taking within the application.
Use the quick notes to help you capture important reminders or information swiftly without navigating away from the main window.

{: .no_toc}
##### How to use the Quick Notes<br>

**1. Adding Notes**:
Click into the Quick Notes Box and type your notes.
Remember to hit the `Save` button to keep your notes for future reference.
Unsaved notes will be lost when the main window is closed.
<div markdown="block" class="alert alert-info">
**:information_source: Notes about Saving:** <br>
The Quick Notes box will turn green upon saving latest changes.
![Quick Notes](images/ug/QuickNotesSaved.png){: .centered-image }
</div>

**2. Editing Notes**:
Click into the Quick Notes Box and make your changes. You can select text to copy, cut, or delete as needed.

**3. Clearing Notes**:
To clear the contents of your Quick Notes and start with a clean slate, simply click the `Clear` button.
This will remove all text until you decide to save new notes.


{: .no_toc}
#### Calendar Window
ToothTracker's Calendar Window provides a visual representation of your clinic's schedule. This view becomes available after executing a [Calendar Command](#viewing-calendar--view-calendar).
It allows you to easily understand your clinic's appointments and availability at a glance.

![Calendar Window](images/ug/CalendarWindowAnnotated.png){: .centered-image-full-size }

|   | Component           | Description                                                                                                                                                 |
|---|---------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1 | View Toggle         | The View Toggle allows you to switch between different calendar views: Day, Week, Month, or Year to get a more precise or broader overview of appointments. |
| 2 | Navigation Buttons  | The navigation arrows let you move to the previous or next time periods, depending on the currently selected view (day, week, month, or year).              |
| 3 | Appointment Entries | This section displays the specifics of each appointment, including the appointment ID, patient name, dentist name and appointment time.                     |


### Using ToothTracker's CLI
ToothTracker is optimized for use via a CLI which means you can do what you want to get done just
by using text input (known as commands).

Right now, ToothTracker only understands certain commands (the complete list of commands can be found in [Features](#features))
and these commands must be formatted in a specific way. So let’s learn how to communicate your needs to ToothTracker!


{: .no_toc}
#### How to Input Commands
Think of the [Command Input](#main-window) as ToothTracker’s ‘ears’ — always ready to listen to your instructions.

1. Click on the Command Input box.
2. Type in your command.
3. Press ‘Enter’ on your keyboard (or ‘return’ if you're on a Mac).

That's it! ToothTracker has just executed your command. Yes, it's as simple as that!

{: .no_toc}
#### Understanding Command Format
Every command you input follows a simple structure to help ToothTracker understand your needs:

* **Command Word:** This is the first word of your command. It acts as a unique keyword that tells ToothTracker precisely what command you want to execute.
* **Index:** The index is simply a number to uniquely identify each patient, dentist or appointment. When your command relates to a specific patient, dentist or appointment, you'll need to use an index. 
* **Flags:** These are markers to distinguish between inputs. A flag is usually followed by a placeholder.
* **Placeholders:** These are temporary labels that you'll replace with actual data. For instance, replace 'TREATMENT' in `tr/TREATMENT` with the real name of a treatment, like `tr/Braces`.


### Trying out your first commands
Can't wait to get started with ToothTracker?
Let's go through some straightforward commands to get a feel for how easy managing your clinic's data can be.

<div markdown="span" class="alert alert-info">
   <span id="text">
      **:information_source:** Remember, the images in this section are just **examples** to guide you.
         Your ToothTracker will show information specific to your own clinic.
   </span>
</div>


Let's start with adding and managing your clinic's dental team:

1. **Welcoming a new dentist**:
Suppose Dr. Jonathan Goh is the latest addition to your dental team. Let's get him into the ToothTracker system. <br>
Type `add-dentist n/Jonathan Goh p/92095568 e/jonathan.goh@gmail.com y/3 s/Paediatric Dentistry` and press Enter.
   - Just like that, Dr. Jonathan Goh is part of your digital roster!

   ![trying-command-add-dentist-example](images/ug/add-dentist-example.png){: .centered-image-full-size }

2. **Saying farewell**: If Dr. Alex Yeoh is leaving your clinic, you can keep your records up-to-date by removing his details.
   Simply run `delete-dentist 1`.
   - After executing the command, Dr. Alex Yeoh's information is now deleted from ToothTracker.

<div markdown="span" class="alert alert-primary">
   <span id="text">
      **:bulb:** Always ensure the `DENTIST_ID` matches the identifier on the dentist's card within ToothTracker.
   </span>
</div>

   ![trying-command-delete-dentist-example](images/ug/delete-dentist-example.png){: .centered-image-full-size }

Now let's see how easy it is to manage patient information.

1. **Registering a new patient**: Suppose you have a new patient, named Jean, onboarding your clinic. <br>
Enter `add-patient n/Jean p/95339212 b/14-09-2001 g/F` and press enter.
   - Notice that you've created a new patient, Jean!

   ![trying-command-add-patient-example](images/ug/add-patient-example.png){: .centered-image-full-size }

2. **Updating patient info**: Now, suppose that Alex wants to update his phone number. Easy! Just type in `edit-patient 1 p/82019452`.
   - Done! Alex's phone number has been updated!

   ![trying-command-edit-patient-example](images/ug/edit-patient-example.png){: .centered-image-full-size }

Awesome! Now that you've gotten familiar with ToothTracker's commands, feel free to explore more features in the
[Features](#features) section to fully leverage ToothTracker's capabilities.