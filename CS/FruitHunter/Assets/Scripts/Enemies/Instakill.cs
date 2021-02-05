using UnityEngine;

public class Instakill : MonoBehaviour
{

    void OnTriggerEnter2D(Collider2D collision) 
    {
        if (collision.transform.CompareTag("Player"))
        {
            collision.transform.GetComponent<PlayerRespawn>().vidas = 1;
            collision.transform.GetComponent<PlayerRespawn>().getHitted();
        }
    }

}