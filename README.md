#Navigation drawer (library)

It requires 14+ API and android support v7  23.2.1 (AppCompatActivity + Toolbar)


<b>Originally from</b><br>
<a href="https://github.com/rudsonlive/NavigationDrawer-MaterialDesign" target="_blank">RudsonLive</a>

#How to add to your project

###<b>Gradle</b>

```java
dependencies {
        compile 'br.com.liveo:navigationdrawer-material:2.5.1'
}
```
###<b>Maven</b>

```xml
<dependency>
  <groupId>br.com.liveo</groupId>
  <artifactId>navigationdrawer-material</artifactId>
  <version>2.5.1</version>
  <type>aar</type>
</dependency>
```

<b>In your styles.xml choose your version:</b>

    <!--Customize here the subject of your application-->
```xml
    <style name="myTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/nliveo_blue_colorPrimary</item>
        <item name="colorPrimaryDark">@color/nliveo_blue_colorPrimaryDark</item>
        <item name="colorAccent">@color/nliveo_blue_colorPrimaryDark</item>
    </style>
````
    <!--Here will be the theme of the class that will extends NavigationLiveo-->
```xml
    <style name="nLiveoDrawer" parent="Theme.nLiveo">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/nliveo_blue_colorPrimary</item>
        <item name="colorPrimaryDark">@color/nliveo_blue_alpha_colorPrimaryDark</item>
        <item name="colorAccent">@color/nliveo_blue_colorPrimaryDark</item>
    </style>
```
<b>Also there is nLiveo.Theme.Light theme<b><br>

<a href="https://gist.github.com/rudsonlive/5f4001ac00fcd4dfc1a4" target="_blank">Available colors</a>

note: colorPrimaryDark property theme "nLiveoDrawer" should receive a color with alpha eg # 80RRGGBB - The "# 80" will ensure the transparency of statusBar.

<b>Remember to set your theme in your AndroidManifest.xml:</b>

```xml
    <application
    <!--Theme of your application-->
        android:theme="@style/myTheme" >
```      
```xml
        <activity
    <!--Theme of the class that will extends NavigationLiveo-->        
            android:name=".MainActivity"
            android:theme="@style/nLiveoDrawer" //This is only necessary if using the NavigationLiveo
        </activity>
    </application>
````

#In your Activity...

<b>Create a class and it extends the NavigationLiveo and implement the br.liveo.interfaces.OnItemClickListener.</b>

Ex: public class <a href="https://github.com/rudsonlive/NavigationDrawer-MaterialDesign/blob/master/demo/src/main/java/br/liveo/ndrawer/ui/activity/MainActivity.java" target="_blank">MainActivity</a> extends NavigationLiveo implements OnItemClickListener {

###Do not use the method "onCreate" and "setContentView" of your Activity, you will use the method "onInt"

<b>In the method "onInt" inform the items on your list</b>

```java
    private HelpLiveo mHelpLiveo;

    @Override
    public void onInt(Bundle savedInstanceState) {
        // User Information
        this.userName.setText("Rudson Lima");
        this.userEmail.setText("rudsonlive@gmail.com");
        this.userPhoto.setImageResource(R.drawable.ic_rudsonlive);
        this.userBackground.setImageResource(R.drawable.ic_user_background_first);

        // Creating items navigation
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(R.string.inbox), R.drawable.ic_inbox_black_24dp, 7);
        mHelpLiveo.addSubHeader(getString(R.string.categories)); //Item subHeader
        mHelpLiveo.add(getString(R.string.starred), R.drawable.ic_star_black_24dp);
        mHelpLiveo.add(getString(R.string.sent_mail), R.drawable.ic_send_black_24dp);
        mHelpLiveo.add(getString(R.string.drafts), R.drawable.ic_drafts_black_24dp);
        mHelpLiveo.addSeparator(); // Item separator
        mHelpLiveo.add(getString(R.string.trash), R.drawable.ic_delete_black_24dp);
        mHelpLiveo.add(getString(R.string.spam), R.drawable.ic_report_black_24dp, 120);

        //with(this, Navigation.THEME_DARK). add theme dark
        //with(this, Navigation.THEME_LIGHT). add theme light

        with(this) // default theme is dark
                .startingPosition(2) //Starting position in the list
                .addAllHelpItem(mHelpLiveo.getHelp())
                .footerItem(R.string.settings, R.drawable.ic_settings_black_24dp)
                .setOnClickUser(onClickPhoto)
                .setOnPrepareOptionsMenu(onPrepare)
                .setOnClickFooter(onClickFooter)
                .build();
    }
````

<br>In the method "onItemClick" you can get the position of the clicked item and the layout that you must inform the replace is the library R.id.container.</b>

```java
    @Override //The "R.id.container" should be used in "beginTransaction (). Replace"
    public void onItemClick(int position) {
        FragmentManager mFragmentManager = getSupportFragmentManager();
        Fragment mFragment = new FragmentMain().newInstance(mHelpLiveo.get(position).getName());

        if (mFragment != null){
            mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
        }
    }    
````

User OnPrepareOptionsMenu onClick - Inform the listener in .setOnPrepareOptionsMenu(onPrepare) method in onInit (); <br>
```java
    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
        }
    };
```

User photo onClick - Inform the listener in .setOnClickUser(onClickPhoto) method in onInit (); <br>
```java
    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            closeDrawer();
        }
    };

```
Footer onClick - Inform the listener in .setOnClickFooter(onClickFooter) method in onInit (); <br>
```java
    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            closeDrawer();
        }
    };
```
