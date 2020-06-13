package com.example.svd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularValueDecomposition;

import java.util.ArrayList;

import static java.text.BreakIterator.DONE;

public class MainActivity extends AppCompatActivity {

    SingularValueDecomposition svd;
    private TextView sVal;
    private TextView uVal;
    private TextView vVal;
    private TextView vVelocity;
    private ArrayList<float[]> velocity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sVal = (TextView) findViewById(R.id.S);
        uVal = (TextView) findViewById(R.id.U);
        vVal = (TextView) findViewById(R.id.V);
        vVelocity = (TextView) findViewById(R.id.velocitydata);

        velocity = new ArrayList<>();

        RealMatrix covMatrix = MatrixUtils.createRealMatrix(3, 3);
//        covMatrix.setEntry(0,0, 2);
//        covMatrix.setEntry(0,1,3);
//        covMatrix.setEntry(0,2,4);
//        covMatrix.setEntry(1,0,5);
//        covMatrix.setEntry(1,1,6);
//        covMatrix.setEntry(1,2,7);
//        covMatrix.setEntry(2,0,2);
//        covMatrix.setEntry(2,1,3);
//        covMatrix.setEntry(2,2,4);
        //#############################################
//        covMatrix.setEntry(0,0, -3);
//        covMatrix.setEntry(0,1,13);
//        covMatrix.setEntry(0,2,1);
//        covMatrix.setEntry(1,0,11);
//        covMatrix.setEntry(1,1,-1);
//        covMatrix.setEntry(1,2,-8);
//        covMatrix.setEntry(2,0,1);
//        covMatrix.setEntry(2,1,-3);
//        covMatrix.setEntry(2,2,1);
        //#############################################
        covMatrix.setEntry(0,0, 4);
        covMatrix.setEntry(0,1,-6);
        covMatrix.setEntry(0,2,6);
        covMatrix.setEntry(1,0,-15);
        covMatrix.setEntry(1,1,-8);
        covMatrix.setEntry(1,2,-2);
        covMatrix.setEntry(2,0,-10);
        covMatrix.setEntry(2,1,2);
        covMatrix.setEntry(2,2,10);
        svd = new SingularValueDecomposition(covMatrix);

        sVal.setText(svd.getS().toString());
        uVal.setText(svd.getU().toString());
        vVal.setText(svd.getV().toString());

        float[] temp = new float[]{1,2,3};

        velocity.add(temp);
        velocity.add(temp);
        velocity.add(temp);
        int sdd = velocity.size();
        vVelocity.setText(Integer.toString(sdd));
//        svd.getS();
//        svd.getV();
//        svd.getU();
        
        DONE(0);
    }

    private void DONE(int i) {
    }
}
