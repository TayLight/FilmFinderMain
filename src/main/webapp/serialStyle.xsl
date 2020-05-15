<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:x="http://foobar.com" exclude-result-prefixes="x">
    <xsl:template match="/">
        <html>
            <body>
                <table border="1">
                    <tr bgcolor="#000080">
                        <th align="left">Id</th>
                        <th align="left">Title</th>
                        <th align="left">Year start</th>
                        <th align="left">Year finish</th>
                        <th align="left">Number of episodes</th>
                        <th align="left">Number of seasons</th>
                        <th align="left">Imdb</th>
                    </tr>
                    <xsl:for-each  select="//x:person" >
                        <tr>
                            <td>
                                <xsl:value-of select="x:serialId"/>
                            </td>
                            <td>
                                <xsl:value-of select="x:title"/>
                            </td>
                            <td>
                                <xsl:value-of select="x:yearStart"/>
                            </td>
                            <td>
                                <xsl:value-of select="x:yearFinish"/>
                            </td>
                            <td>
                                <xsl:value-of select="x:numEpisodes"/>
                            </td>
                            <td>
                                <xsl:value-of select="x:numSeasons"/>
                            </td>
                            <td>
                                <xsl:value-of select="x:imdb"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
