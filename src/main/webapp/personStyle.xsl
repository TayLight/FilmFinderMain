<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>My CD Collection</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th align="left">Id</th>
                        <th align="left">Name</th>
                        <th align="left">Family</th>
                        <th align="left">Birthday</th>
                        <th align="left">Country</th>
                    </tr>
                    <xsl:for-each  select="result/persons/person" >
                        <tr>
                            <td>
                                <xsl:value-of select="personId"/>
                            </td>
                            <td>
                                <xsl:value-of select="firstName"/>
                            </td>
                            <td>
                                <xsl:value-of select="secondName"/>
                            </td>
                            <td>
                                <xsl:value-of select="birtday"/>
                            </td>
                            <td>
                                <xsl:value-of select="country"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
