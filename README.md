# Problem

Paparazzi tests fail to identify regressions for certain layout combinations. 

Changing the text in this sample layout should result in a test failure, but it does not. 

Changing the layout params of the TextView from `MATCH_PARENT` to `WRAP_CONTENT` and centering the view in the parent fixes the issue.

# Steps to Reproduce

Clone this sample

## With match_parent (does not work correctly)

Run:
```
./gradlew :app:cleanRecordPaparazzi
./gradlew :app:verifyPaparazzi
//Test passes as expected
//Find and replace APPLICATION_TEST_MAIN_PASS in layout file with APPLICATION_TEST_MAIN_FAIL
./gradlew :app:verifyPaparazzi
//Test passes, **but should fail**
```

## With wrap_content (does work correctly)

Replace:
```
    <TextView
        android:id="@+id/text"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="APPLICATION_TEST_MAIN_PASS"
        tools:ignore="HardcodedText" />
```

With:
```
    <TextView
        android:id="@+id/text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:text="APPLICATION_TEST_MAIN_PASS"
        tools:ignore="HardcodedText" />
```

Run:
```
./gradlew :app:cleanRecordPaparazzi
./gradlew :app:verifyPaparazzi
//Test passes as expected
//Find and replace APPLICATION_TEST_MAIN_PASS in layout file with APPLICATION_TEST_MAIN_FAIL
./gradlew :app:verifyPaparazzi
//Test fails as expected
//Revert change
./gradlew :app:verifyPaparazzi
//Test passes as expected
```
