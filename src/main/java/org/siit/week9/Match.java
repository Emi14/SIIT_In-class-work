package org.siit.week9;

import java.util.Arrays;
import java.util.List;

public class Match
{
    List<Veteran> participants;
    Veteran winner;

    public Match(Veteran v1, Veteran v2)
    {
        this.participants = Arrays.asList(v1, v2);
    }

    public List<Veteran> getParticipants()
    {
        return participants;
    }
}
