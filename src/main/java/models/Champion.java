package models;

import javafx.scene.image.Image;

import java.util.LinkedList;

public class Champion
{
    public String m_id;
    public String m_type;
    public String m_name;
    public String m_title;

    public LinkedList<String> m_tags;

    public Integer m_hpPerLevel;
    public Integer m_armorPerLevel;
    public Integer m_spellBlockPerLevel;
    public Integer m_hpRegenPerLevel;
    public Integer m_attackDamagePerLevel;
    public Integer m_attackSpeedPerLevel;

    public Image m_championAvatar;

    private Champion(String m_id,
                     String m_type,
                     String m_name,
                     String m_title,
                     LinkedList<String> m_tags,
                     Integer m_hpPerLevel,
                     Integer m_armorPerLevel,
                     Integer m_spellBlockPerLevel,
                     Integer m_hpRegenPerLevel,
                     Integer m_attackDamagePerLevel,
                     Integer m_attackSpeedPerLevel,
                     Image m_championAvatar)
    {
        this.m_id = m_id;
        this.m_type = m_type;
        this.m_name = m_name;
        this.m_title = m_title;
        this.m_tags = m_tags;
        this.m_hpPerLevel = m_hpPerLevel;
        this.m_armorPerLevel = m_armorPerLevel;
        this.m_spellBlockPerLevel = m_spellBlockPerLevel;
        this.m_hpRegenPerLevel = m_hpRegenPerLevel;
        this.m_attackDamagePerLevel = m_attackDamagePerLevel;
        this.m_attackSpeedPerLevel = m_attackSpeedPerLevel;
        this.m_championAvatar = m_championAvatar;
    }
}
