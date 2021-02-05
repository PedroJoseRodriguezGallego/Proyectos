using UnityEngine;
using UnityEngine.Audio;


public class FruitCollected : MonoBehaviour
{
    public SpriteRenderer spriteRenderer;
    public GameObject collected;
    public AudioSource collectedSound;
    public AudioSource winSound;
    public GameObject fruits;


    private void OnTriggerEnter2D(Collider2D collision)
    {
        if(collision.CompareTag("Player"))
        {
            if(fruits.transform.childCount == 1)
            {
                winSound.Play();
            }
                else
                {
                    collectedSound.Play();
                }

            spriteRenderer.enabled = false;
            collected.SetActive(true);
            Invoke("HideSprite",0.3f);
            Destroy(gameObject,0.5f);
        }
    }


    void HideSprite()
    {
        collected.SetActive(false);
    }

}