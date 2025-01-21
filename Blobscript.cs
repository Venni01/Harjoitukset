using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Blobscript : MonoBehaviour
{
     public Rigidbody2D myRigidbody;
    public float  flapStrength;
    public Script logic;
    public bool birdIsAlive = true;
    void Start()
    {
         logic = GameObject.FindGameObjectWithTag("Logic").GetComponent<Script>();

    }

    void Update()
    {
       if (Input.GetKeyDown(KeyCode.Space) == true && birdIsAlive == true){
        myRigidbody.velocity = Vector2.up * flapStrength;
       }
    
    }

    private void OnCollisionEnter2D(Collision2D collision){

     logic.gameOver();
     birdIsAlive = false;

    }
    
}
