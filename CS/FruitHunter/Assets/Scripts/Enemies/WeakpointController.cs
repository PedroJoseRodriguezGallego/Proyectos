using UnityEngine;

public class WeakpointController : MonoBehaviour
{
    public Rigidbody2D player;
    public Animator animator;
    public AudioSource hitSound;


    void OnTriggerEnter2D(Collider2D collider) 
    {
        if(collider.transform.CompareTag("Player"))
        {
            player.velocity = new Vector2 (player.position.x, 2.25f);

            hitSound.Play();
            animator.Play("Hit");

            Destroy(transform.parent.gameObject.transform.parent.gameObject,0.2f);
        }
    }

}