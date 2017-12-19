# AndroidAIDLLearnDemo
A simple practice about Android AIDL in the Android Studio

## The step of using AIDL in the android Studio
1. New the AIDL file in the module,but notice that AS would place the aidl file in the main/aidl/yourpackage,but it would not generate the Java file,so i remove the aidl file to the java floder in the same package,it worked for me!
2. New your Service class and implement Stub that int the aidl's sub class.You have to override the method you declared in the aidl file.
3. Create ServiceConnect object in your activity,you should override the onServiceConnected method that you can get a reference of the Stub object.
4. Invoke the bindService in your Activity
5. Call the Stub's method by the reference you hold in the step 3.It means you call the method from the remote.
