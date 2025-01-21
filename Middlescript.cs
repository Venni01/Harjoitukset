using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Middlescript : MonoBehaviour
{
public Script logic;

    void Start()
    {
        logic = GameObject.FindGameObjectWithTag("Logic").GetComponent<Script>();
    }

    // Update is called once per frame
    void Update()
    {
        
    }
    private void OnTriggerEnter2D(Collider2D collision){
        if ( collision.gameObject.layer == 3){

        
        logic.addScore(1);
        }
    }
}
