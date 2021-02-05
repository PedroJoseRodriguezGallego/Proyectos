using UnityEngine;

public class FanController : MonoBehaviour
{
    public Animator animator;
    public Rigidbody2D playerRB;
    public bool toUp;
    public bool toDown;
    public bool toRight;
    public bool toLeft;
    public bool focus;


    void Update() 
    {
        if(focus)
        {
            if(toUp)
            {
                playerRB.AddForce(Vector2.up * 3f);
            }
                else if(toDown)
                {
                    playerRB.AddForce(Vector2.down * 3f);
                }
                    else if(toLeft)
                    {
                        playerRB.AddForce(Vector2.left * 3f);
                    }
                        else if(toRight)
                        {
                            playerRB.AddForce(Vector2.right * 3f);
                        }
        }
    }


    private void OnTriggerEnter2D(Collider2D collider) 
    {
        if(collider.transform.CompareTag("Player"))
        {
            focus = true;
        }
    }


    private void OnTriggerExit2D(Collider2D collider) 
    {
        if(collider.transform.CompareTag("Player"))
        {
            focus = false;
        }
    }

}