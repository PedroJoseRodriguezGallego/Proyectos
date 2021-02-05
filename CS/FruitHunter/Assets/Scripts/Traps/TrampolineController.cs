using UnityEngine;

public class TrampolineController : MonoBehaviour
{
    public Animator animator;
    public Rigidbody2D playerRB;
    public Transform playerT;
    public AudioSource sound;


    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.transform.CompareTag("Player"))
        {
            animator.SetBool("Jumping",true);
            sound.Play();

            if(playerT.position.y < this.transform.position.y)
            {
                playerRB.velocity = new Vector2(playerRB.velocity.x,-5f);
            }
                if(playerT.position.y > this.transform.position.y)
                {
                    playerRB.velocity = new Vector2(playerRB.velocity.x,5f);
                }
        }
    }


    private void OnCollisionExit2D(Collision2D collision)
    {
        if (collision.transform.CompareTag("Player"))
        {
            animator.SetBool("Jumping",false);
        }
    }
    
}