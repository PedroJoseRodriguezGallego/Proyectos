using System.Collections;
using UnityEngine;

public class BasicAI : MonoBehaviour
{
    public SpriteRenderer spriteRenderer;
    public Transform[] movePoints;

    public float speed = 0.5f;
    public float timeToWait = 2f;
    float waitTime;
    int position = 0;

    Vector2 actualPosition;



    void Start()
    {
        waitTime = timeToWait;
    }


    void Update()
    {
        StartCoroutine(checkMovement());

        transform.position = Vector2.MoveTowards(transform.position,movePoints[position].transform.position,speed * Time.deltaTime);

        if(Vector2.Distance(transform.position,movePoints[position].transform.position) < 0.1f)
        {
            if(waitTime <= 0)
            {
                if(movePoints[position] != movePoints[movePoints.Length -1])
                {
                    position++;
                }
                    else
                    {
                        position = 0;
                    }

                waitTime = timeToWait;
            }
                else
                {
                    waitTime -= Time.deltaTime;
                }
        }
    
    }

    IEnumerator checkMovement() // Una corrutina es una funcion que se llama en el Update - FixedUpdate pero lo hace dependiendo del tiempo que le hayamos indicado que tarde
    {
        actualPosition = transform.position;
        yield return new WaitForSeconds(0.3f); // Tiempo de espera

        if(transform.position.x > actualPosition.x)
        {
            spriteRenderer.flipX = true;
        }   
            else if(transform.position.x < actualPosition.x)
            {
                spriteRenderer.flipX = false;
            }
    }

}