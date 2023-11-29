# Modeling a Doctor's Office in Java

This project models a doctor's office in Java. It consists of three classes: `Patient`, `Doctor`, and `Main`.

## Task

The task was to write a program that models a doctor's office. In this office, there are doctors and patients. The patients can register with the practice and are then sent to the waiting room. The patients from the waiting room are called in turn by the doctors for treatment and discharged at the end of the treatment. The waiting room was to be realized using the data structure Queue.

In the second task, this situation was to be supplemented with the information that a distinction is made between patients with statutory and private health insurance. Although this procedure is highly questionable, in this case privately insured patients are preferred. When they register, they are placed further up in the list, directly behind the last privately insured person. Statutorily insured persons are simply added to the back as before.

## Classes

### Patient

The `Patient` class represents a patient. It has two attributes: `name` and `isPrivate`. `name` is the name of the patient and `isPrivate` is a boolean value indicating whether the patient is privately insured.

### Doctor

The `Doctor` class represents a doctor. It has a `waitingRoom` queue where patients are admitted. If a privately insured patient is admitted, they are placed ahead of the statutorily insured patients. The doctor calls the patients in the order of their appearance in the waiting room.

### Main

The `Main` class is the entry point of the program. It creates a doctor and four patients. The patients are called for treatment in the order of their creation, with privately insured patients being preferred.

## Usage

To run the program, compile it with a Java compiler and run the `Main` class. You should see the patients being called for treatment in order of their priority.
