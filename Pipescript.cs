using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Pipescript : MonoBehaviour
{
public float moveSpeed;
public float deadZone = -60;
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        transform.position = transform.position + (Vector3.left * moveSpeed);
        if (transform.position.x < deadZone){
            Debug.Log("Pipe Deleted");
            Destroy(gameObject);
        }
    }
}
