package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Adds an event listener to the image view that shows an alert when tapped
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Profile");
            builder.setMessage("MADness");
            builder.setPositiveButton("View", (dialog, id) -> {
                // Creates an Intent to MainActivity
                Intent mainActivity = new Intent(this, MainActivity.class);

                // Generates a random integer and passes it to MainActivity
                int random = (int) (Math.random() * 1000000000);
                mainActivity.putExtra("id", random);

                startActivity(mainActivity);
            });
            builder.setNegativeButton("Close", (dialog, id) -> {

            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });

        // Adds an event listener to messageGroupButton to start MessageActivity
        Button messageGroupButton = (Button) findViewById(R.id.messageGroupButton);
        messageGroupButton.setOnClickListener(v -> {
            Intent messageActivity = new Intent(this, MessageGroupActivity.class);
            startActivity(messageActivity);
        });
    }
}