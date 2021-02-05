using UnityEngine;

public class ReachCheckPoint : MonoBehaviour
{
    public AudioSource flag;
    bool reached;

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.CompareTag("Player"))
        {
            if(!reached)
            {
                reached = true;
                flag.Play();
            }
            
            collision.GetComponent<PlayerRespawn>().reachSpawn(transform.position.x, transform.position.y, transform.position.z);
            GetComponent<Animator>().enabled = true;
        }
    }
}