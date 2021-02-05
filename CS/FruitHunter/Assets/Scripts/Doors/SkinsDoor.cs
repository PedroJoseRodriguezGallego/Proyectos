using UnityEngine;

public class SkinsDoor : MonoBehaviour
{
    public GameObject panel;
    public GameObject player;
    public GameObject settingsButton;


    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.transform.CompareTag("Player"))
        {
            settingsButton.SetActive(false);
            panel.gameObject.SetActive(true);
        }
    }

    private void OnTriggerExit2D(Collider2D collision)
    {
        settingsButton.SetActive(true);
        panel.gameObject.SetActive(false);
    }


    #region skins
    public void SetFrogSkin()
    {
        PlayerPrefs.SetString("PlayerSelected", "NinjaFrog");
        player.GetComponent<PlayerSkin>().ChangeSkin();
        settingsButton.SetActive(true);
        panel.gameObject.SetActive(false);
    }

    public void SetPinkManSkin()
    {
        PlayerPrefs.SetString("PlayerSelected", "PinkMan");
        player.GetComponent<PlayerSkin>().ChangeSkin();
        settingsButton.SetActive(true);
        panel.gameObject.SetActive(false);
    }

    public void SetVirtualGuySkin()
    {
        PlayerPrefs.SetString("PlayerSelected", "VirtualGuy");
        player.GetComponent<PlayerSkin>().ChangeSkin();
        settingsButton.SetActive(true);
        panel.gameObject.SetActive(false);
    }

    public void SetMaskDudeSkin()
    {
        PlayerPrefs.SetString("PlayerSelected", "MaskDude");
        player.GetComponent<PlayerSkin>().ChangeSkin();
        settingsButton.SetActive(true);
        panel.gameObject.SetActive(false);
    }
    #endregion

}